import csv

class ReadAndWriteData:

    def __init__(self, file_path):
        self.file_path = file_path
        self.data = []

    def read_data(self):
        with open(self.file_path, 'r', newline='', encoding='utf-8-sig') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                self.data.append(row)

    def display_data(self):
        if not self.data:
            print("No data to display.")
            return

        for row in self.data:
            for key, value in row.items():
                print(f"{key}:{value}")
            print()

if __name__ == "__main__":
    file_path = "E://techademy//ComprehensiveAssign//Skills.csv"
    data_handler = ReadAndWriteData(file_path)
    data_handler.read_data()
    data_handler.display_data()
