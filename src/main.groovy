import java.text.NumberFormat

def file = new URL("https://gist.githubusercontent.com/anonymous/747d5e3bbc57949d8bfe5fd82f359acb/raw/761277a2dcacafb3c06a1e6d0e405ca252098c09/Employee%2520Records.txt").getText()

def sal
def topSal

def data = file.eachLine { line ->
    if (line.contains('SAL')) {
        sal = Integer.parseInt(line.replaceAll("[\\D]", ""))
        if (sal > topSal) {
            topSal = sal
        }
    }
}

println NumberFormat.getCurrencyInstance(Locale.US).format(topSal)