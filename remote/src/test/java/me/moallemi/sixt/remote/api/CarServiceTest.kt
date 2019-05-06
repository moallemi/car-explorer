package me.moallemi.sixt.remote.api

import me.moallemi.sixt.remote.datasource.CarFactory
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

class CarServiceTest {

    private lateinit var mockRetrofit: MockRetrofit
    private lateinit var retrofit: Retrofit

    @Before
    fun setUp() {
        retrofit = Retrofit.Builder().baseUrl("http://test.com")
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val behavior = NetworkBehavior.create()

        mockRetrofit = MockRetrofit.Builder(retrofit)
            .networkBehavior(behavior)
            .build()
    }

    @Test
    fun `getCars when successful`() {
        val delegate = mockRetrofit.create(CarService::class.java)
        val carServiceMock = CarServiceMockSuccess(delegate)

        carServiceMock.getCars()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listOf(CarFactory.createCarDto()))
    }

    @Test
    fun `getCars when fails`() {
        val delegate = mockRetrofit.create(CarService::class.java)
        val carServiceMock = CarServiceMockFailure(delegate)

        carServiceMock.getCars()
            .test()
            .assertNotComplete()
            .assertFailure(HttpException::class.java)
            .assertError { error ->
                (error as HttpException).code() == 404
            }
    }
}