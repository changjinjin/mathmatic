## 适配器模式（Adapter）
+ 设计模式学习笔记：适配器模式（Adapter）
+ https://blog.csdn.net/sinat_27245917/article/details/109058024
+ 一、适配器模式介绍
    - 适配器模式是设计模式中结构型模式的一种。它将一个类的接口转换为期望的另外一个接口，适配器模式可以将原本由于接口不匹配而不能一起工作的那些类可以一起工作。
+ 二、适配器模式有很多优点
    - 例如：可以使两个没有的关联的类一起运行、提高类的复用型、增加类的透明度、灵活性好等。
    - 但是要注意的是适配器模式只是一个解决现有系统问题的设计模式，不应该用于早期的系统设计之中。
    - 在系统中过多的使用适配器会使系统非常凌乱，不易进行整体把控。如果不是很有必要应该尽量避免使用适配器，而是对系统进行重构。
    - 适配器的使用场景很多，例如 JDK 中的 HashSet 和 TreeSet 都使用了适配器模式，准确来说，它们俩都是适配器。
    - 适配器的实现方式有两种：继承或依赖，推荐使用依赖的方式。
+ 三、适配器模式示例
  - 使用场景：
  原有系统中有个接口，其输出为字符串数组，现有另一个系统需要使用其输出结果，但新系统只接收字符串集合，这时就可以增加一个适配器来做转换工作，使两个系统可以在一起运行。
