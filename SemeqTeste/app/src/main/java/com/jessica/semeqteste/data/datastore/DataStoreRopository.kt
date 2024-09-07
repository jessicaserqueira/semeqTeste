package com.jessica.semeqteste.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "userPreferences")

object PreferencesKeys {
    val ACCESS_TOKEN = stringPreferencesKey("access_token")
    val USERNAME = stringPreferencesKey("username")
}

internal class DataStoreRepository(context: Context) {
    private val context = context.dataStore

    suspend fun saveToken(token: String) {
        context.edit { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN] = token
        }
    }

    val token = this.context.data.map { preferences ->
        preferences[PreferencesKeys.ACCESS_TOKEN]
    }

    suspend fun saveUsername(key: String, name: String) {
        context.edit { preferences ->
            preferences[stringPreferencesKey(key)] = name
        }
    }

    fun getUsername(key: String): Flow<String?> {
        return context.data.map { preferences ->
            preferences[stringPreferencesKey(key)]
        }
    }

}