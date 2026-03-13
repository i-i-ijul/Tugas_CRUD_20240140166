Penjelasan Kode:
1. Struktur folder yang saya tambahkan pada intellij: 
  <img width="596" height="335" alt="Image" src="https://github.com/user-attachments/assets/9102fc77-905d-4f5f-bcfc-7b072799904e" />
  
2. Struktur file yang saya buat untuk menyimpan program:
  <img width="574" height="571" alt="Image" src="https://github.com/user-attachments/assets/c76a8e7e-fef8-4ce1-9417-5fb3549ae98a" />

3. Menambahkan program index.html pada resources/static untuk tampilan web:
   
   <img width="314" height="85" alt="Image" src="https://github.com/user-attachments/assets/b641ce80-4ec8-496c-96de-596f5efe5237" />

5. Query MySQL untuk tabel ktp:
   
   <img width="436" height="212" alt="Image" src="https://github.com/user-attachments/assets/7b78b22c-2bb2-469a-a273-ebc619379c68" />

6. Struktur kode KtpController:
  package com.example.demo.controller;

  import com.example.demo.dto.KtpDto;
  import com.example.demo.service.KtpService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.*;

  import java.util.List;

  @RestController
  @RequestMapping("/api/ktp")
  @CrossOrigin(origins = "*")
  public class KtpController {

    @Autowired
    private KtpService service;

    @GetMapping
    public List<KtpDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KtpDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<KtpDto> create(@RequestBody KtpDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KtpDto> update(@PathVariable Integer id, @RequestBody KtpDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Data berhasil dihapus!");
    }
}

6. Struktur kode untuk KtpDto.java:
   
   <img width="459" height="365" alt="Image" src="https://github.com/user-attachments/assets/3f2398d4-9d35-4232-b0ff-60c266e52cae" />

7. Struktur kode KtpMapper.java:
   
   <img width="719" height="823" alt="Image" src="https://github.com/user-attachments/assets/f7b9d844-c8d9-412a-8cb6-297d648db901" />

8. Struktur kode Ktp.java:
   
   <img width="803" height="576" alt="Image" src="https://github.com/user-attachments/assets/cc53ebac-b18e-4d19-860b-722cdf2fb606" />

9. Tampilan Web:

    <img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/e7b9f507-e6c8-417a-abaa-3b0cce3331dd" />

10. Pop Up (interaksi dengan user) ketika menghapus data:

    <img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/da2fa1dc-77a3-4d30-b75d-66e4ae1a5fce" />
