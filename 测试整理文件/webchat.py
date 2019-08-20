from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest,time,re


def setUp(self):
    self.driver = webdriver.Chrome()
    self.base_url = "http://39.107.118.86:8088/"
    self.ver =[]
    self.accept = True

def connection(self):
    self.driver.get(self.base_url)


def register(self,i):
    driver = self.driver
    driver.get(self.base_url)
    time.sleep(1)
    driver.find_element_by_xpath("/html/body/div/div[3]/a").click()
    time.sleep(1)
    driver.find_element_by_css_selector("#change_margin_1 > input").send_keys(i)
    driver.find_element_by_css_selector("#change_margin_2 > input").send_keys("000000")
    driver.find_element_by_css_selector("#change_margin_3 > input").click()

def loading(self):
    driver = self.driver
    driver.get(self.base_url)
    time.sleep(1)
    driver.find_element_by_xpath("//*[@id='change_margin_1']/input").send_keys("hx")
    driver.find_element_by_xpath("//*[@id='change_margin_2']/input").send_keys("111111")
    driver.find_element_by_xpath("//*[@id='change_margin_3']/input").click()


def tearDown(self):
    self.driver.quit()
    self.accept([],self.ver)


count=0
webdriver
for count in range(0,10):
    count += 1
    setUp(webdriver)
    connection(webdriver)
    print(count)