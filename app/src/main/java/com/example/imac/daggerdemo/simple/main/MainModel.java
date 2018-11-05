package com.example.imac.daggerdemo.simple.main;

import com.example.imac.daggerdemo.base.BaseModel;
import com.example.imac.daggerdemo.manager.RepositoryManager;
import com.example.imac.daggerdemo.simple.bean.Person;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

public class MainModel implements MainContract.Model {
    

    @Override
    public void getPersonList() {
        new ArrayList<Person>();
    }
}
