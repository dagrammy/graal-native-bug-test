import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;


public class SetterTest {

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

    System.out.println("diret method invocation");
    System.out.println(">>>>> " + method.invoke(bean) + " <<<<<");

    Method setter = beanClass.getMethod("setValue", Long.class);
    MethodHandle setterHandle = MethodHandles.publicLookup().unreflect(setter);
    setterHandle.invoke(bean, 1L);

    System.out.println("without MethodHandle after set to 1");
    System.out.println(">>>>> " + ((BeanLong) bean).getValue() + " <<<<<");

    System.out.println("got MethodHandle by unreflect after set to 1");
    out = (Long) methodHandle.invoke(bean);
    System.out.println(">>>>> " + out + " <<<<<");

    System.out.println("direct method invocation after set to 1");
    System.out.println(">>>>> " + method.invoke(bean) + " <<<<<");

    setterHandle.invoke(bean, null);

    System.out.println("without MethodHandle after set to null");
    System.out.println(">>>>> " + ((BeanLong) bean).getValue() + " <<<<<");

    System.out.println("got MethodHandle by unreflect after set to null");
    out = (Long) methodHandle.invoke(bean);
    System.out.println(">>>>> " + out + " <<<<<");

    System.out.println("direct method invocation after set to null");
    System.out.println(">>>>> " + method.invoke(bean) + " <<<<<");

  }

}
