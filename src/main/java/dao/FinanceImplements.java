package dao;

import dao.impl.FinanceInterface;

/**
 * Created by user on 2016/9/13.
 */
public class FinanceImplements implements FinanceInterface {
    @Override
    public void doCheck(String name) {
        System.out.println("Finance---");
    }
}
