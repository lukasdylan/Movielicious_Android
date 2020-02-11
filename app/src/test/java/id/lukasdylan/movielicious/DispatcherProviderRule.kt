package id.lukasdylan.movielicious

import id.lukasdylan.movielicious.core.utils.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by lukasdylan on 2020-02-11
 */
class DispatcherProviderRule : TestRule {

    @Mock
    lateinit var dispatcherProvider: DispatcherProvider

    override fun apply(base: Statement?, description: Description?): Statement {
        MockitoAnnotations.initMocks(this)
        return object : Statement() {
            override fun evaluate() {
                Mockito.`when`(dispatcherProvider.background()).thenReturn(Dispatchers.Unconfined)
                Mockito.`when`(dispatcherProvider.default()).thenReturn(Dispatchers.Unconfined)
                base?.evaluate()
            }

        }
    }

}