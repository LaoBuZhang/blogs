import requests

url = "http://www.baidu.com"
response = requests.get(url)

# 获取HTTP状态码
status_code = response.status_code
print("HTTP状态码:", status_code)

# 获取响应头部
headers = response.headers
print("响应头部:")
for header, value in headers.items():
    print(header + ": " + value)

# 获取响应信息str类型
html = response.text
print("响应信息1:")
print(html)

# 获取响应信息bytes类型
html = response.content
html=html.decode("utf-8")
print("响应信息2:")
print(html)