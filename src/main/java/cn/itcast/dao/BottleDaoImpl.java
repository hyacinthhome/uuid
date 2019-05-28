package cn.itcast.dao;

import cn.itcast.entity.Bottle;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Random;

public class BottleDaoImpl extends HibernateDaoSupport implements BottleDao{
    @Override
    public List<Bottle> findCon(String con, String value){
        DetachedCriteria criteria=DetachedCriteria.forClass(Bottle.class);
        criteria.add(Restrictions.like(con,value));
        List<Bottle> list=(List<Bottle>)this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
    @Override
    public Bottle gtone_ex(String user_username){
        List<Bottle> list=(List<Bottle>)this.getHibernateTemplate().find("from Bottle u where u.bottle_user.user_username!=?",user_username);
        if(list.size()==0)
            return null;
        else{
            Random r=new Random();
            int index=r.nextInt(list.size());
            list.get(index).setBottle_usedtime(list.get(index).getBottle_usedtime()+1);
            this.getHibernateTemplate().update(list.get(index));
            return list.get(index);
        }
    }
}
