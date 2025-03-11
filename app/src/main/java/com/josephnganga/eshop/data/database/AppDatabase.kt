package com.josephnganga.eshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity

@Database(entities = [UserCartEntity::class, FavoriteProductEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
