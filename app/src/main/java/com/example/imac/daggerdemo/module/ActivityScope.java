package com.example.imac.daggerdemo.module;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/12
 * 描   述：
 * ================================================
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
