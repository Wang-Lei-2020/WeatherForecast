import pandas as pd
from mod_timeseries.weather_model import ProcessData

data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates = ['date'])

data.query("date.dt.day == 28 & date.dt.month == 6",inplace = True)
#print(data)

p = ProcessData(data,10,'max')
p.process_minmax()