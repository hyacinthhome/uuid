package cn.itcast.dao;

import cn.itcast.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    @Override
    public List<User> findCon(String con, String value){
        DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.like(con,value));
        List<User> list=(List<User>)this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
    @Override
    public User save(User user){
        this.getHibernateTemplate().save(user);
        return user;
    }
}
