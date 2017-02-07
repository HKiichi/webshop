package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.UserAccount;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 6-2-2017.
 */
@Stateless
public class UserAccountService extends AbstractCrudRepository{

    @Override
    protected Class<UserAccount> getEntityClass(){
        return UserAccount.class;

    }
}
