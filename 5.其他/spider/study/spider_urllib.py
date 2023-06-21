import urllib.request

req=urllib.request.Request("http://www.baidu.com")
response=urllib.request.urlopen(req)

# 获取HTTP状态码
status_code = response.getcode()
print("HTTP状态码:", status_code)

# 获取响应头部
headers = response.info()
print("响应头部:")
for header in headers:
    print(header + ": " + headers[header])

# 获取响应信息
html = response.read().decode("utf-8")
print("响应信息:")
print(html)