import pandas as pd
from mod_timeseries.weather_model import ProcessData

data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates = ['date'])

p = ProcessData(data,10,'max')
p.process_minmax()