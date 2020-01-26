package id.lukasdylan.movielicious.core.preferences

/**
 * Created by lukasdylan on 2020-01-25
 */
interface Preference<T> {
    suspend fun getValue(): T
    suspend fun setValue(value: T)
}