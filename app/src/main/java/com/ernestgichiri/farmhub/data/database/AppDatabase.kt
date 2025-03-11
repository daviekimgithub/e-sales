package com.ernestgichiri.farmhub.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ernestgichiri.farmhub.domain.entity.cart.UserCartEntity
import com.ernestgichiri.farmhub.domain.entity.product.FavoriteProductEntity

@Database(entities = [UserCartEntity::class, FavoriteProductEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
