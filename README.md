# MagaofeiAppium

### 推荐环境

- macOS 10.11及以上
- IntelliJ IDEA 
- Appium 1.64及以上
- iOS 10
- JDK 7 及以上

### 介绍

使用Java编写，基于Appium-Javaclient的自动化测试代码，目前只编写了iOS部分，主要测试了TALPublish和TALPlayer两款应用。

### 启动方式

1. 通过读取Excel信息, 完成Appium (iOS) 测试
2. 直接执行测试用例代码(Java), 完成Appium(iOS)测试

#### 启动前设置DesiredCapabilities

目前只写了TALPublish和TALPlayer这两个测试用例和相关代码。

启动前需要找到 `com/magaofei/tal/config.properties` 文件，修改其中的属性，一般需要修改系统版本、bundleId（用来指定测试的App）、udid（指定测试的真机）。相关的属性读取方法的实现代码在 `com/magaofei/tal/config/CapabilitiesSetup.java`

或者可以直接使用代码设置，在测试用例的 `setUp` 中进行修改

##### 使用WebDriverAgent获取界面元素

快捷方法: 直接运行目录下的 `runWebDriverTest.sh` 提示输入电脑密码即可

#### 使用代码启动

找到 `testcase` 文件夹，里面根据App划分目录，进入要测试的相关目录，右键 `MainCase` Run，就可以启动并运行

##### 



#### 使用Excel配置信息启动

文件名是 `ios_testcase.xlsx `

目前实现的是通过读取Excel来调用相关的方法操作Appium，以每一行为一个操作步骤，通过首列的数字标识来区分不同的测试用例，遇到错误会往上抛出异常，并和结果写入到相关列中。

找到 `testcase` 文件夹，里面根据App划分目录，进入要测试的相关目录，右键 `ExcelCase` Run，就可以启动并运行

缺陷：不如代码灵活，有许多需要完善的地方





