import os
import sys
import time
import codecs
import pickle
import datetime
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
# pip install selenium==4.8.3

def asr_main(contest_id):
    dict = {}
    # 读出
    with open("dict.pkl", "rb") as f:
        dict = pickle.load(f)

    #格式： 2023/05/07 17:59:08
    cnt=""
    with open("cnt.txt") as f:
        cnt = f.read()
    cnt = datetime.datetime.strptime(cnt, "%Y/%m/%d %H:%M:%S")
    maxCnt=cnt


    # 获取部分
    problem_set_id = contest_id # problem set id为比赛id
    url = "https://pintia.cn/problem-sets/"+problem_set_id+"/submissions"


    executable_path = 'chromedriver.exe'
    service = webdriver.chrome.service.Service(executable_path)
    service.start()

    driver = webdriver.Chrome(service=service)
    driver.get(url)
    cookies = [{'name': 'PTASession', 'value': "42c71d33-4002-407f-bfa5-c58a56545aa0"}]
    # cookies = [{'name': 'PTASession', 'value': '2388399b-744b-4838-8aef-e96207042409'}]
    for cookie in cookies:
        driver.add_cookie(cookie)
    driver.get(url)


    time.sleep(1)

    html = driver.execute_script("return document.documentElement.outerHTML")
    soup = BeautifulSoup(html, 'html.parser')
    titles = soup.find_all('tr')
    for title in titles:
        if(title.text[0:1]=="提"):
            continue
        s=title.text[0:19]
        s = datetime.datetime.strptime(s, "%Y/%m/%d %H:%M:%S")
        if(s>maxCnt):
            maxCnt=s
        if(s<cnt):
            flag=False
        if(s>=cnt):
            position = title.text.index("详")
            position1=title.text.index("情")
            position2=title.text.index(")")

            status=title.text[19:position]
            problem_id=title.text[position1+1:position1+2]
            language=title.text[position1+2:position2+1]

            if "正确" in status:
                position3=title.text.index("ms")
                team_id=title.text[position3+2:position3+5]
                team_name=title.text[position3+6:]
                print(team_id,team_name,problem_id,status,language)


    time.sleep(5)
    flag=True
    while True:
        if(flag==False):
            break
        next_page_button = driver.find_element(By.XPATH,'/html/body/div[1]/div[1]/div[1]/div[3]/div[3]/button[2]')
        class_name = next_page_button.get_attribute("class")
        if "disabled" in class_name:
            break
        else:
            driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
            time.sleep(1)
            ActionChains(driver).move_to_element(next_page_button).click().perform()
        time.sleep(0.5)

        html = driver.execute_script("return document.documentElement.outerHTML")
        soup = BeautifulSoup(html, 'html.parser')
        titles = soup.find_all('tr')
        for title in titles:
            if(title.text[0:1]=="提"):
                continue
            s=title.text[0:19]
            s = datetime.datetime.strptime(s, "%Y/%m/%d %H:%M:%S")
            if(s>maxCnt):
                maxCnt=s
            if(s<cnt):
                flag=False
            if(s>=cnt):
                position = title.text.index("详")
                position1=title.text.index("情")
                position2=title.text.index(")")

                status=title.text[19:position]
                problem_id=title.text[position1+1:position1+2]
                language=title.text[position1+2:position2+1]

                if "正确" in status:
                    position3=title.text.index("ms")
                    team_id=title.text[position3+2:position3+5]
                    team_name=title.text[position3+6:]
                    print(team_id,team_name,problem_id,status,language)
                    


    maxCnt = maxCnt.strftime("%Y/%m/%d %H:%M:%S")
    with open('cnt.txt', 'w') as f:
        f.write(maxCnt)

    # 写入
    with open("dict.pkl", "wb") as f:
        pickle.dump(dict, f)