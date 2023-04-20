package com.example.springhexagonal.global.aop

import org.aspectj.lang.annotation.Aspect
import org.springframework.aop.Advisor
import org.springframework.aop.aspectj.AspectJExpressionPointcut
import org.springframework.aop.support.DefaultPointcutAdvisor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource
import org.springframework.transaction.interceptor.RollbackRuleAttribute
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute
import org.springframework.transaction.interceptor.TransactionInterceptor

@Configuration
@Aspect
class TransactionAspect (
        private val transactionManager: TransactionManager
) {

    @Bean
    fun transactionAdviceAdvisor(): Advisor {

        val pointcut = AspectJExpressionPointcut()
        pointcut.expression = "@within(com.example.springhexagonal.annotation.UseCase)" //적용될 위치

        return DefaultPointcutAdvisor(pointcut, transactionAdvice()) // 생성한 포인트컷을 기반으로 어드바이저 객체를 생성
    }

    @Bean
    fun transactionAdvice(): TransactionInterceptor {

        val source = MatchAlwaysTransactionAttributeSource() //모든 메소드에 대해 동일한 트랜잭션 속성을 적용
        val transactionAttribute = RuleBasedTransactionAttribute() //규칙에 따라 트랜잭션 속성을 정의

        transactionAttribute.setName("Transaction")
        transactionAttribute.rollbackRules = listOf(
                RollbackRuleAttribute(Exception::class.java) //Exception 클래스를 예외로 발생시 롤백하도록 설정
        )
        source.setTransactionAttribute(transactionAttribute)

        return TransactionInterceptor(transactionManager, source)
    }
}