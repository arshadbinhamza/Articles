package com.abh.articles

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext

class CoroutineRuleConfig : TestWatcher(), TestCoroutineScope by createTestCoroutineScope(
    TestCoroutineDispatcher() + TestCoroutineExceptionHandler() + EmptyCoroutineContext
) {

    override fun starting(description: Description) {

        super.starting(description)
        Dispatchers.setMain(this.coroutineContext[ContinuationInterceptor] as CoroutineDispatcher)
    }

    override fun finished(description: Description) {

        super.finished(description)
        Dispatchers.resetMain()
    }
}