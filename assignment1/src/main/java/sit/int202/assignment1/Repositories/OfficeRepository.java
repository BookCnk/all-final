package sit.int202.assignment1.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.assignment1.Entities.Office;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;    //สร้างแล้วเก็บไว้ที่นี่

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    } // return Offices ทั้งหมดจากฐานข้อมูล.

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    } //ค้นหาและ return ข้อมูลของ Office จากฐานข้อมูลโดยใช้ officeCode.

    public void close() {   //ปิดการใช้งาน entity manager
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
    //Create => insert
    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //All Delete
    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }
    //Delete by Code ลบข้อมูล Office จากฐานข้อมูลโดยใช้ officeCode.
    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
    //Update อัปเดตข้อมูล Office ในฐานข้อมูล.
    public boolean update(Office newOffice) {
        if (newOffice != null) { //newOffice ที่รับเข้ามาไม่ใช่ null
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                entityManager.getTransaction().begin(); // การเปิด Transaction เมื่อได้ Office
                office.setCity(newOffice.getCity());
                office.setPhoneNumber(newOffice.getPhoneNumber());
                office.setAddressLine1(newOffice.getAddressLine1());
                office.setAddressLine2(newOffice.getAddressLine2());
                office.setState(newOffice.getState());
                office.setCountry(newOffice.getCountry());
                office.setPostalCode(newOffice.getPostalCode());
                office.setTerritory(newOffice.getTerritory());
                entityManager.getTransaction().commit();
                return true;
            } // เมทอดจะคืนค่า true เพื่อแสดงว่าการอัปเดตสำเร็จ. ในกรณีที่ไม่พบข้อมูล Office ที่ต้องการอัปเดต, หรือเกิดข้อผิดพลาดในระหว่างการทำ Transaction, เมทอดจะคืนค่า false.
        }
        return false;
    }
    public String getNewOfficeCode(){
        //อยากได้ officeCode ใหม่ ต่อจาก officeCode ที่มีอยู่ในฐานข้อมูล
        //เช่น มี officeCode ที่มีอยู่ 100 แล้ว ต้องการ officeCode ใหม่ ให้ได้ 101
        //เราต้องหา officeCode ที่มีอยู่ แล้ว +1 แล้ว return ออกมา

        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        int max = 0;
        for (Office office : officeList) {
            int officeCode = Integer.parseInt(office.getOfficeCode());
            if (officeCode > max) {
                max = officeCode;
            }
        }
        return String.valueOf(max + 1);
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {    //  ค้นหา field city or country
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }
}
