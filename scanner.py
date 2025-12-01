import socket

def scan_port(ip, port):
    s = socket.socket()
    s.settimeout(0.5)
    try:
        s.connect((ip, port))
        return True
    except:
        return False

def main():
    ip = input("Enter target IP: ")
    print(f"\nScanning {ip}...\n")

    for port in range(1, 1025):   # Scans 1–1024 (well-known ports)
        if scan_port(ip, port):
            print(f"Port {port} is OPEN")

    print("\nScan Completed ✔️")

if __name__ == "__main__":
    main()
