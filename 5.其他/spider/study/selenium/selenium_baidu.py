from selenium import webdriver
from selenium.webdriver.common.by import By

url = "http://www.baidu.com"

# 配置驱动
executable_path = 'chromedriver.exe' #填写驱动的路径
service = webdriver.chrome.service.Service(executable_path)
service.start()

# 使得页面不会自动关闭
option = webdriver.ChromeOptions()
option.add_experimental_option("detach", True)

driver = webdriver.Chrome(service=service,options=option)
driver.get(url)

ans=driver.find_element(By.XPATH,'/html/body/div[1]/div[1]/div[5]/div/div/form/span[2]/input')
print(ans.get_attribute("value"))