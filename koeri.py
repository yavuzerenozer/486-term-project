from bs4 import BeautifulSoup
import requests
import json
import datetime

url = 'http://www.koeri.boun.edu.tr/scripts/lst2.asp'
page = requests.get(url)

today = datetime.date.today()

format_koeri_today = today.strftime(
    "%Y")+"."+today.strftime("%m")+"."+today.strftime("%d")

earthquakes = []

line = ""

soup = BeautifulSoup(page.content, 'html.parser')
table = soup.find("pre").contents[0]

print(table)

classified_earthquakes = {
    "date": [],
    "time": [],
    "lat": [],
    "lng": [],
    "depth": [],
    "ml": [],
    "type": [],
}

for i in range(len(table)):
    if table[i:i+4] == "2021":
        for k in range(len(table)):
            if table[i+k] == "\n":
                earthquakes.append(line)
                line = ""
                break
            else:
                line = line + table[i+k]
                
print(earthquakes)

well_edited = []
well_edited_json = []

for l in range(len(earthquakes)):
    line_edit = earthquakes[l].split(" ")
    needed = []
    needed_json = {
    "date" : "",
    "time" : "",
    "lat" : "",
    "lng" : "",
    "depth" : "",
    "ml" : "",
    "type" : ""
    }
    for i in range(len(line_edit)):
        if(line_edit[i] and line_edit[i] != "-.-"):
            needed.append(line_edit[i].strip())
    for i in range(len(needed)):
    	if i == 0: 
    		needed_json["date"] = needed[i]
    	elif i ==1: 
    		needed_json["time"] = needed[i]
    	elif i ==2: 
    		needed_json["lat"] = needed[i]
    	elif i ==3: 
    		needed_json["lng"] = needed[i]
    	elif i ==4: 
    		needed_json["depth"] = needed[i]
    	elif i ==5: 
    		needed_json["ml"] = needed[i]
    	elif i == len(needed)-1:
    	 	needed_json["type"] = needed[-1]
    	
    print(needed_json)
    well_edited.append(needed)
    well_edited_json.append(needed_json)

# next step: add specs to dictionary to access in a nice way

today = {
    "date" : [],
    "time" : [],
    "lat" : [],
    "lng" : [],
    "depth" : [],
    "ml" : [],
    "type" : [],
}

k=0

while(k<len(well_edited)):
    if well_edited[0][0] == well_edited[k][0]:
        today["date"].append(well_edited[k][0])
        today["time"].append(well_edited[k][1])
        today["lat"].append(well_edited[k][2])
        today["lng"].append(well_edited[k][3])
        today["depth"].append(well_edited[k][4])
        today["ml"].append(well_edited[k][5])
        if well_edited[k][-1][0] == '0' or well_edited[k][-1][0] == '1' or well_edited[k][-1][0] == '2':
            today["type"].append(well_edited[k][-3])
        else:
            today["type"].append(well_edited[k][-1])
    classified_earthquakes["date"].append(well_edited[k][0])
    classified_earthquakes["time"].append(well_edited[k][1])
    classified_earthquakes["lat"].append(well_edited[k][2])
    classified_earthquakes["lng"].append(well_edited[k][3])
    classified_earthquakes["depth"].append(well_edited[k][4])
    classified_earthquakes["ml"].append(well_edited[k][5])

    if well_edited[k][-1][0] == '0' or well_edited[k][-1][0] == '1' or well_edited[k][-1][0] == '2':
        classified_earthquakes["type"].append(well_edited[k][-3])
        k += 2
    else:
        classified_earthquakes["type"].append(well_edited[k][-1])
        k += 1
with open('last_500.json', 'w') as fp:
    json.dump(well_edited_json, fp, indent=8)
    last_500_json = json.dumps(well_edited_json)

with open('today.json', 'w') as fptr:
    json.dump(today, fptr, indent=8)
    today = json.dumps(today)

def json_change(data, filename="app.json"):
    with open(filename, "w") as file:
        json.dump(data, file, indent=8)


with open("app.json", "r+") as file:
    data = json.load(file)
    date = data["date"][-1]
    time = data["time"][-1]
    index_needed = 0
    while(index_needed < len(well_edited)):
        if(well_edited[index_needed][0] == date and well_edited[index_needed][1] == time):
            break

        if well_edited[index_needed][-1][0] == '0' or well_edited[index_needed][-1][0] == '1' or well_edited[index_needed][-1][0] == '2':
            index_needed += 2
        else:
            index_needed += 1
    index_needed -= 1
    flag = 0
    while(flag <= index_needed):
        if(len(well_edited[index_needed]) < 3):
            index_needed -=1;
            continue
        data["date"].append(well_edited[index_needed][0])
        data["time"].append(well_edited[index_needed][1])
        data["lat"].append(well_edited[index_needed][2])
        data["lng"].append(well_edited[index_needed][3])
        data["depth"].append(well_edited[index_needed][4])
        data["ml"].append(well_edited[index_needed][5])
        if well_edited[index_needed][-1][0] == '0' or well_edited[index_needed][-1][0] == '1' or well_edited[index_needed][-1][0] == '2':
            data["type"].append(well_edited[index_needed][-3])
            index_needed -= 1

        else:
            data["type"].append(well_edited[index_needed][-1])
            index_needed -= 1

        json_change(data)
