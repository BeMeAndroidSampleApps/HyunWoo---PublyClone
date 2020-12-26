package com.sopt.publyclone

import com.sopt.publyclone.network.PublyService
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun retrofitTest() {
        val service = Retrofit.Builder()
            .baseUrl("http://52.79.150.197:3000/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val retrofitService = service.create(PublyService::class.java)

        val profiles = retrofitService.fetchCurator()

        val body = profiles.execute().body()
        if (body != null) {
            assertTrue(body.datas.size == 6)
        }
    }
}