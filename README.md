# graal-native-bug-test
### simple project to reproduce a strange behaviour with MethodHandles for return types Long/Integer/Boolean using graal native

> prerequisites: GraalVM & native-image tool must be installed 

#### Compile classes
```sh
javac BeanLong.java BeanInteger.java BeanString.java BeanBoolean.java MethodHandleTest.java MethodHandleTestAll.java
````

#### Test using Long only

```sh
java MethodHandleTest
```

Output:
```
without MethodHandle
>>>>> null <<<<<
got MethodHandle by unreflect
>>>>> null <<<<<
got MethodHandle by findVirtual
>>>>> null <<<<<
```

#### Compile native and run it
```sh
native-image MethodHandleTest
```

```sh
./methodhandletest
```

Output:
```
without MethodHandle
>>>>> null <<<<<
got MethodHandle by unreflect
>>>>> 0 <<<<<
got MethodHandle by findVirtual
>>>>> 0 <<<<<
```

#### Test using Long, Integer, Boolean and String

```sh
java MethodHandleTestAll
```

Output:
```
------ Test with Long --------
without MethodHandle
>>>>>null<<<<<
got Long MethodHandle by unreflect
>>>>>null<<<<<
got Long MethodHandle by findVirtual
>>>>>null<<<<<
------ Test with Integer --------
without MethodHandle
>>>>>null<<<<<
got Integer MethodHandle by unreflect
>>>>>null<<<<<
got Integer MethodHandle by findVirtual
>>>>>null<<<<<
------ Test with Boolean --------
without MethodHandle
>>>>>null<<<<<
got Boolean MethodHandle by unreflect
>>>>>null<<<<<
got Boolean MethodHandle by findVirtual
>>>>>null<<<<<
------ Test with String --------
without MethodHandle
>>>>>null<<<<<
got String MethodHandle by unreflect
>>>>>null<<<<<
got String MethodHandle by findVirtual
>>>>>null<<<<<

```

#### Compile native and run it
```sh
native-image MethodHandleTestAll
```

```sh
./methodhandletestall
```

Output:
```
------ Test with Long --------
without MethodHandle
>>>>>null<<<<<
got Long MethodHandle by unreflect
>>>>>0<<<<<
got Long MethodHandle by findVirtual
>>>>>0<<<<<
------ Test with Integer --------
without MethodHandle
>>>>>null<<<<<
got Integer MethodHandle by unreflect
>>>>>0<<<<<
got Integer MethodHandle by findVirtual
>>>>>0<<<<<
------ Test with Boolean --------
without MethodHandle
>>>>>null<<<<<
got Boolean MethodHandle by unreflect
>>>>>false<<<<<
got Boolean MethodHandle by findVirtual
>>>>>false<<<<<
------ Test with String --------
without MethodHandle
>>>>>null<<<<<
got String MethodHandle by unreflect
>>>>>null<<<<<
got String MethodHandle by findVirtual
>>>>>null<<<<<

```
