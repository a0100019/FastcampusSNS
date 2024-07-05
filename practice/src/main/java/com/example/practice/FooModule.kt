package com.example.practice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FooModule {

    @CustomQualifier
    @Provides
    fun provideFoo1():Foo{
        return Foo(id = "foo1")
    }

    @Provides
    fun provideFoo2():Foo{
        return Foo(id = "foo2")
    }


}