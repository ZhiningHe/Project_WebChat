from selenium import webdriver
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest,time,re

driver = webdriver.Chrome()
driver.get('http://localhost:8088/')
time.sleep(3)
driver.find_element_by_xpath("/html/body/div/div[3]/a").click()
time.sleep(3)
driver.find_element_by_css_selector("#change_margin_1 > input").send_keys("test")
driver.find_element_by_css_selector("#change_margin_2 > input").send_keys("000000")
driver.find_element_by_css_selector("#change_margin_3 > input").click()
