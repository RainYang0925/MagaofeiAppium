#如果遇到权限问题，
#sudo chmod 755 example.sh

#解锁keychain，以便可以正常的签名应用，

#两种输入的方式，第一种是直接输入，第二种是提示，再输入
#PASSWORD="#"
echo -n "Please input your password"
# -s 保密输入
read -s PASSWORD
security unlock-keychain -p $PASSWORD ~/Library/Keychains/login.keychain

# 获取设备的UDID
UDID=$(idevice_id -l | head -n1)

# 运行测试
#xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination "$UDID" test

xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination id=$UDID test

