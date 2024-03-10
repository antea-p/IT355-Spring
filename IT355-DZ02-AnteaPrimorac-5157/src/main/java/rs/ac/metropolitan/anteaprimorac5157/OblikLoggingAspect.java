package rs.ac.metropolitan.anteaprimorac5157;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class OblikLoggingAspect {

    @Pointcut("execution(* rs.ac.metropolitan.anteaprimorac5157.OblikService.*(..))")
    private void oblikServiceMethods() {
    }

    @Pointcut("execution(* rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.*.*(..))")
    private void oblikImplementationsMethods() {
    }


    @Pointcut("oblikServiceMethods() || oblikImplementationsMethods()")
    private void loggingPointcut() {
    }

    @Pointcut("execution(rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.*.new(..))")
    private void shapeConstructors() {
    }

    @Before("shapeConstructors() && args(radius)")
    public void validateConstructorArguments(JoinPoint joinPoint, double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative: " + radius);
        }
    }

    @Before("loggingPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @After("loggingPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "loggingPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + ", Return: " + result);
    }

    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("AfterThrowing: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +", Error: " + error.getMessage());
    }

    @Around("loggingPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String identifier = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        System.out.println("Around (Before): " + identifier);
        Object proceed = joinPoint.proceed();
        System.out.println("Around (After): " + identifier);
        return proceed;
    }
}
