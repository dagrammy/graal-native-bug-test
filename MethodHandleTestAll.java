import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;


public class MethodHandleTestAll {

  public static void main(String... args) throws Exception {
    System.out.println("------ Test with Long --------");
    Class<?> beanLongClass = BeanLong.class;
    Object beanLong = new BeanLong();

    System.out.println("without MethodHandle");
    printOut(((BeanLong) beanLong).getValue());

    System.out.println("got Long MethodHandle by unreflect");
    Method methodLong = beanLongClass.getMethod("getValue");
    MethodHandle mhLong = MethodHandles.publicLookup().unreflect(methodLong);
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleLong(mhLong, beanLong));

    System.out.println("got Long MethodHandle by findVirtual");
    MethodHandle anotherMhLong = MethodHandles.publicLookup()
        .findVirtual(beanLongClass, "getValue", MethodType.methodType(Long.class));
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleLong(anotherMhLong, beanLong));

    System.out.println("------ Test with Integer --------");
    Class<?> beanIntegerClass = BeanInteger.class;
    Object beanInteger = new BeanInteger();

    System.out.println("without MethodHandle");
    printOut(((BeanInteger) beanInteger).getValue());

    System.out.println("got Integer MethodHandle by unreflect");
    Method methodInteger = beanIntegerClass.getMethod("getValue");
    MethodHandle mhInteger = MethodHandles.publicLookup().unreflect(methodInteger);
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleInteger(mhInteger, beanInteger));

    System.out.println("got Integer MethodHandle by findVirtual");
    MethodHandle anotherMhInteger = MethodHandles.publicLookup()
        .findVirtual(beanIntegerClass, "getValue", MethodType.methodType(Integer.class));
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleInteger(anotherMhInteger, beanInteger));

    System.out.println("------ Test with Boolean --------");
    Class<?> beanBooleanClass = BeanBoolean.class;
    Object beanBoolean = new BeanBoolean();

    System.out.println("without MethodHandle");
    printOut(((BeanBoolean) beanBoolean).getValue());

    System.out.println("got Boolean MethodHandle by unreflect");
    Method methodBoolean = beanBooleanClass.getMethod("getValue");
    MethodHandle mhBoolean = MethodHandles.publicLookup().unreflect(methodBoolean);
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleBoolean(mhBoolean, beanBoolean));

    System.out.println("got Boolean MethodHandle by findVirtual");
    MethodHandle anotherMhBoolean = MethodHandles.publicLookup()
        .findVirtual(beanBooleanClass, "getValue", MethodType.methodType(Boolean.class));
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleBoolean(anotherMhBoolean, beanBoolean));

    System.out.println("------ Test with String --------");
    Class<?> beanStringClass = BeanString.class;
    Object beanString = new BeanString();

    System.out.println("without MethodHandle");
    printOut(((BeanString) beanString).getValue());

    System.out.println("got String MethodHandle by unreflect");
    Method methodString = beanStringClass.getMethod("getValue");
    MethodHandle mhString = MethodHandles.publicLookup().unreflect(methodString);
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleString(mhString, beanString));

    System.out.println("got String MethodHandle by findVirtual");
    MethodHandle anotherMhString = MethodHandles.publicLookup()
        .findVirtual(beanStringClass, "getValue", MethodType.methodType(String.class));
    // Call to MH returns 0 instead of null
    printOut(callMethodHandleString(anotherMhString, beanString));

  }

  private static void printOut(Object value) {
    System.out.print(">>>>>");
    System.out.print(value);
    System.out.println("<<<<<");
  }

  private static Long callMethodHandleLong(MethodHandle mh, Object obj) {
    try {
      return (Long) mh.invoke(obj);
    } catch (Throwable throwable) {
      throw new RuntimeException("", throwable);
    }
  }

  private static Integer callMethodHandleInteger(MethodHandle mh, Object obj) {
    try {
      return (Integer) mh.invoke(obj);
    } catch (Throwable throwable) {
      throw new RuntimeException("", throwable);
    }
  }

  private static String callMethodHandleString(MethodHandle mh, Object obj) {
    try {
      return (String) mh.invoke(obj);
    } catch (Throwable throwable) {
      throw new RuntimeException("", throwable);
    }
  }

  private static Boolean callMethodHandleBoolean(MethodHandle mh, Object obj) {
    try {
      return (Boolean) mh.invoke(obj);
    } catch (Throwable throwable) {
      throw new RuntimeException("", throwable);
    }
  }

}
