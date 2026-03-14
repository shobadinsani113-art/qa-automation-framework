11•	TEST CASE ID: AB-TC-001
•	Linked Requirement: AB-REQ-001
•	Scenario Type: Positive
•	Test Type: Functional/Black-Box
•	Test Level: Component
•	Test Description: Verifikasi halaman A/B Testing terbuka
•	Pre-conditions: Halaman utama terbuka
•	Test Steps: 1. Klik link A/B Testing
•	Input/Test Data: N/A
•	Expected Result: Halaman A/B Testing terbuka dengan teks deskripsi
•	Actual Result: Halaman A/B Testing terbuka dengan teks deskripsi
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

12•	TEST CASE ID: AB-TC-002
•	Linked Requirement: AB-REQ-002
•	Scenario Type: Positive
•	Test Type: Functional / Exploratory
•	Test Level: System
•	Test Description: Verifikasi variasi konten A/B Testing
•	Pre-conditions: Halaman A/B Testing terbuka
•	Test Steps: 1. Refresh halaman beberapa kali
•	Input/Test Data: N/A
•	Expected Result: Teks yang ditampilkan berubah sesuai variasi (misal “A/B Test Control” atau “A/B Test Variation”)
•	Actual Result: Teks yang ditampilkan berubah sesuai variasi (misal "A/B Test Control" atau "A/B Test Variation")
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: Medium

13•	TEST CASE ID: AR-TC-001
•	Linked Requirement: AR-REQ-001
•	Scenario Type: Positive
•	Test Type: Functional/Black-Box
•	Test Level: Component
•	Test Description: Verifikasi tombol "Add Element" muncul
•	Pre-conditions: Halaman Add/Remove Elements terbuka
•	Test Steps: 1. Klik link Add/Remove Elements
•	Input/Test Data: N/A
•	Expected Result: Tombol “Add Element” tampil
•	Actual Result: Tombol "Add Element" tampil
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

14•	TEST CASE ID: AR-TC-002
•	Linked Requirement: AR-REQ-002
•	Scenario Type: Positive
•	Test Type: Functional / Regression
•	Test Level: Component Integration
•	Test Description: Verifikasi tombol "Delete" muncul setelah klik “Add Element”
•	Pre-conditions: Halaman Add/Remove Elements terbuka
•	Test Steps: 1. Klik tombol “Add Element”
•	Input/Test Data: N/A
•	Expected Result: Tombol “Delete” muncul di bawahnya
•	Actual Result: Tombol "Delete" muncul di bawahnya
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

15•	TEST CASE ID: AR-TC-003
•	Linked Requirement: AR-REQ-003
•	Scenario Type: Positive
•	Test Type: Functional
•	Test Level: Component
•	Test Description: Verifikasi tombol "Delete" menghapus elemen
•	Pre-conditions: Ada tombol “Delete”
•	Test Steps: 1. Klik tombol “Delete”
•	Input/Test Data: N/A
•	Expected Result: Elemen terhapus dari halaman
•	Actual Result: Elemen terhapus dari halaman
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

16•	TEST CASE ID: BA-TC-001
•	Linked Requirement: BA-REQ-001
•	Scenario Type: Negative
•	Test Type: Functional / Security
•	Test Level: System Integration
•	Test Description: Verifikasi Basic Auth gagal dengan credential salah
•	Pre-conditions: Halaman utama terbuka
•	Test Steps: 1. Klik link Basic Auth 2. Input user/pass salah
•	Input/Test Data: user: test, pass: test
•	Expected Result: Prompt authentication gagal, akses ditolak
•	Actual Result: Prompt authentication gagal, akses ditolak
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

17•	TEST CASE ID: BA-TC-002
•	Linked Requirement: BA-REQ-002
•	Scenario Type: Positive
•	Test Type: Functional / Security
•	Test Level: System Integration
•	Test Description: Verifikasi Basic Auth berhasil login dengan credential benar
•	Pre-conditions: Halaman utama terbuka
•	Test Steps: 1. Klik link Basic Auth 2. Input user: admin, pass: admin
•	Input/Test Data: user: admin, pass: admin
•	Expected Result: Login berhasil, halaman sukses terbuka
•	Actual Result: Login berhasil, halaman sukses terbuka
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

18•	TEST CASE ID: BI-TC-001
•	Linked Requirement: BI-REQ-001
•	Scenario Type: Positive
•	Test Type: Functional
•	Test Level: Component
•	Test Description: Verifikasi halaman Broken Images terbuka
•	Pre-conditions: Halaman utama terbuka
•	Test Steps: 1. Klik link Broken Images
•	Input/Test Data: N/A
•	Expected Result: Halaman terbuka dengan daftar gambar
•	Actual Result: Halaman terbuka dengan daftar gambar
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: High

19•	TEST CASE ID: BI-TC-002
•	Linked Requirement: BI-REQ-002
•	Scenario Type: Negative
•	Test Type: Non-Functional / Usability
•	Test Level: System
•	Test Description: Verifikasi gambar yang broken menampilkan ikon rusak
•	Pre-conditions: Halaman Broken Images terbuka
•	Test Steps: 1. Amati semua gambar
•	Input/Test Data: N/A
•	Expected Result: Minimal 1 gambar tidak tampil (broken)
•	Actual Result: Minimal 1 gambar tidak tampiil (broken)
•	PASS/FAIL: PASS
•	BUG-ID: -
•	Priority: Medium

20•	TEST CASE ID: BI-TC-003
•	Linked Requirement: BI-REQ-003
•	Scenario Type: Positive
•	Test Type: Non-Functional / Accessibility
•	Test Level: System
•	Test Description: Verifikasi gambar memiliki atribut alt
•	Pre-conditions: Halaman Broken Images terbuka
•	Test Steps: 1. Inspect gambar
•	Input/Test Data: N/A
•	Expected Result: Setiap gambar memiliki alt text
•	Actual Result: Setiap gambar tidak memiliki alt text (kosong)
•	PASS/FAIL: FAIL
•	BUG-ID: BUG-002
•	Priority: Medium