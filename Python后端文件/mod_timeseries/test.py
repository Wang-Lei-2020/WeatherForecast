import pandas as pd
from mod_timeseries.weather_model import ProcessData

for i in range(6,32):
    data = pd.read_csv('F:/Git/Weather/maxmin.csv', parse_dates=['date'])
    data.query("date.dt.day == @i & date.dt.month == 7", inplace=True)
    p = ProcessData(data, 10, 'max')
    p.process_minmax()
