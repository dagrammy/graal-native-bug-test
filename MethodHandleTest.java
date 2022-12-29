import java.beans.PropertyDescriptor;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;


public class MethodHandleTest {

  public static void main(String... args) throws Throwable {
    Class<?> beanClass = BeanLong.class;
    Object bean = new BeanLong();

    System.out.println("without MethodHandle");
    System.out.println(">>>>> " + ((BeanLong) bean).getValue() + " <<<<<");

    System.out.println("got MethodHandle by unreflect");
    Method method = beanClass.getMethod("getValue");
    MethodHandle methodHandle = MethodHandles.publicLookup().unreflect(method);
    // Call to MH returns 0 instead of null
    Long out = (Long) methodHandle.invoke(bean);
    System.out.println(">>>>> " + out + " <<<<<");

    System.out.println("got MethodHandle by findVirtual");
    MethodHandle anotherMh = MethodHandles.publicLookup()
        .findVirtual(beanClass, "getValue", MethodType.methodType(Long.class));
    // Call to MH returns 0 instead of null
    Long anotherOut = (Long) anotherMh.invoke(bean);
    System.out.println(">>>>> " + anotherOut + " <<<<<");

    System.out.println("getDeclaredMethod and invoke on method");
    Method getValue = beanClass.getDeclaredMethod("getValue");
    Long v = (Long) getValue.invoke(bean);
    System.out.println(">>>>> " + v + " <<<<<");
  }

}
