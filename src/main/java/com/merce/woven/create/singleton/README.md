## 单例模式（Singleton）
+ 设计模式学习笔记：单例模式
+ https://blog.csdn.net/sinat_27245917/article/details/107387336
+ 一、单例模式介绍
    - 单例模式属于设计模式中创建型模式的一种，它时 Java 中最简单的设计模式之一。它提供了一种最佳的创建对象的方式。单例模式涉及到一个单一的类，该类负责创建自己的对象，同时要保证只有单个对象被创建，并且提供访问该对象的方式，可以直接使用，不需要实例化该类的对象。
+ 二、实现方式
    - 单例模式的实现有多种方式，其中分为线程安全的和非线程安全两类。
## -----------------------
+ 一、单例模式介绍
+ 二、实现方式
- 1、饿汉式单例（线程安全）推荐
- 2、懒汉式单例（非线程安全）
- 3、懒汉式单例（线程安全，但效率低）
- 4、懒汉式单例（双重校验锁方式，小几率不安全）
- 5、懒汉式单例（双重校验锁，安全）推荐
- 6、静态内部类方式的单例（线程安全）推荐
- 7、枚举方式单例（线程安全，序列化安全）推荐
- 8、CAS实现线程安全的懒汉式单例（线程安全）