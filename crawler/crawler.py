from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import csv
import time

def read_csv():
     with open('providers.csv', mode='r', encoding='utf-8', newline='') as file:
        csv_reader = csv.reader(file)
        next(csv_reader)  # Skip the header row

        for row in csv_reader:
            if row and row[0].strip():
                manufacturer = row[0]
                url = row[2].strip()
                crawl(url, manufacturer)

def write_csv(manufacturer, product):
    with open('products.csv', mode='a', encoding='utf-8', newline='') as file:
        writer = csv.writer(file)
        writer.writerow([manufacturer, product])

def crawl(url, manufacturer):
    options = Options()
    options.headless = True
    driver = webdriver.Chrome(options=options)

    try:
        driver.get(url)
        time.sleep(2) # Wait for page to load content

        html = driver.page_source
        soup = BeautifulSoup(html, 'html.parser')

        if "stiebel-eltron" in url:
            page_number = 1

            while page_number < 8:
                url = f'https://www.stiebel-eltron.de/de/home/produkte-loesungen/erneuerbare_energien/waermepumpe/alle-produkte.html?_charset_=utf-8&enabledFilterName=&enabledFilterValue=&refcode_FSTE_0000011=::&refcode_FSTE_0000012=::&refcode_FSTE_0000014=::&refcode_FSTE_0000015=::&sort=by_relevance&result-counter=110%20Produkte%20entsprechen%20Ihrer%20Auswahl&page={page_number}'
                product_boxes = soup.find_all('div', class_='product-box')

                for box in product_boxes:
                    square_container = box.find('div', class_='square-container')
                    if square_container:
                        header = square_container.find('h3')
                        if header:
                            product_name = header.get_text().strip()
                            write_csv(manufacturer, product_name)
                        else:
                            write_csv(manufacturer, "ERROR")
                page_number += 1
                driver.get(url)
                time.sleep(1)
                html = driver.page_source
                soup = BeautifulSoup(html, 'html.parser')

        elif "vaillant" in url:
            product_container = soup.find_all('div', class_='box')[:11]
            if product_container:
                for product in product_container:
                    product_name = product.find('h2').get_text().strip()
                    write_csv(manufacturer, product_name)

        elif "mitsubishi" in url:
            product_row = soup.find_all('div', class_='me-product-row')
            if product_row:
                for row in product_row:
                    products = row.find_all('h4')
                    for product in products:
                        product_name = product.get_text().strip()
                        write_csv(manufacturer, product_name)

        elif "samsung" in url:
            product_container = soup.find_all('div', class_='single-product-text')
            if product_container:
                for product in product_container:
                    product_name = product.find('h4').get_text().strip()
                    write_csv(manufacturer, product_name)

        elif "bosch" in url:
            product_names = soup.find_all('p', class_='ProductsOverview_title')
            for product in product_names:
                product_name = product.get_text().strip()
                write_csv(manufacturer, product_name)

        elif "buderus" in url:
            product_container = soup.find_all('div', class_='ob-teaser-product__text-wrapper')
            for product in product_container:
                product_name = product.find('span', class_='ob-headline').get_text().strip()
                write_csv(manufacturer, product_name)

        elif "daikin" in url:
            product_names = soup.find_all('h3', class_='product-series-card__title')
            for product in product_names:
                product_name = product.get_text().strip()
                write_csv(manufacturer, product_name)

        elif "kermi" in url:
            product_container = soup.find_all('div', class_='content-block')
            if product_container:
                for product in product_container:
                    product_name = product.find('h3').get_text().strip()
                    write_csv(manufacturer, product_name)

        elif "lgthermav" in url:
            product_names = soup.find_all('p', class_='c1-heading')
            if product_names:
                for product in product_names:
                    product_name = product.get_text().strip()
                    write_csv(manufacturer, product_name)

        elif "wolf" in url:
            product_container = soup.find_all('div', class_='m-teaser-boxed__textblock')
            if product_container:
                for product in product_container:
                    product_name = product.find('h3').get_text().strip()
                    write_csv(manufacturer, product_name)

        elif "zewotherm" in url:
            product_container = soup.find_all('div', class_='text-only__header')
            if product_container:
                for product in product_container:
                    product_name = product.find('h2').get_text().strip()
                    if '&' in product_name:
                        parts = product_name.split('&')
                    for part in parts:
                        write_csv(manufacturer, part.strip())
                    else:
                        write_csv(manufacturer, product_name)


    finally:
        driver.quit()  # Close the browser

read_csv()
