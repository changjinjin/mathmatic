如下图，用户选择合适的策略去创建策略的使用者：
![img.png](img.png)
2.2 使用策略模式的实现方式
使用策略模式需要创建以下几个类和接口：PayStrategy （策略接口）、AliPay （支付宝支付策略）、JDPay （京东支付策略）、WeiXinPay （微信支付策略）、PayContext （策略执行工具）。
![img_1.png](img_1.png)