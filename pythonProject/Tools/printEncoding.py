import chardet


def detect_encoding(file_path):
	with open(file_path, 'rb') as f:
		rawdata = f.read()
		result = chardet.detect(rawdata)
		encoding = result['encoding']
	return encoding


if __name__ == '__main__':
	csv_file = '../data/lasa.csv'
	encoding = detect_encoding(csv_file)
	print(f"The encoding of the CSV file is: {encoding}")
