package org.literacyapp.contentprovider.model.analytics;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.literacyapp.contentprovider.dao.DaoSession;
import org.literacyapp.contentprovider.dao.DeviceDao;
import org.literacyapp.contentprovider.dao.StudentDao;
import org.literacyapp.contentprovider.dao.StudentImageCollectionEventDao;
import org.literacyapp.contentprovider.dao.StudentImageDao;
import org.literacyapp.contentprovider.dao.converter.CalendarConverter;
import org.literacyapp.contentprovider.model.Device;
import org.literacyapp.contentprovider.model.Student;
import org.literacyapp.contentprovider.model.StudentImage;

import java.util.Calendar;
import java.util.List;

/**
 * Based on {@link org.literacyapp.model.gson.analytics.StudentImageCollectionEventGson}
 */
@Entity
public class StudentImageCollectionEvent {

    @Id(autoincrement = true)
    private Long id;

    private long deviceId;

    @NotNull
    @ToOne(joinProperty = "deviceId")
    private Device device;

    @NotNull
    @Convert(converter = CalendarConverter.class, columnType = Long.class)
    private Calendar time;

//    @ToOne
//    private Application application;

    private long studentId;

    @ToOne(joinProperty = "studentId")
    private Student student;

    private String meanFeatureVector;

    @ToMany(referencedJoinProperty = "studentImageCollectionEventId")
    private List<StudentImage> studentImages;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 136770604)
    private transient StudentImageCollectionEventDao myDao;

    @Generated(hash = 862266622)
    public StudentImageCollectionEvent(Long id, long deviceId, @NotNull Calendar time, long studentId,
            String meanFeatureVector) {
        this.id = id;
        this.deviceId = deviceId;
        this.time = time;
        this.studentId = studentId;
        this.meanFeatureVector = meanFeatureVector;
    }

    @Generated(hash = 802935259)
    public StudentImageCollectionEvent() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public Calendar getTime() {
        return this.time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Generated(hash = 708752895)
    private transient Long device__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 983487634)
    public Device getDevice() {
        long __key = this.deviceId;
        if (device__resolvedKey == null || !device__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DeviceDao targetDao = daoSession.getDeviceDao();
            Device deviceNew = targetDao.load(__key);
            synchronized (this) {
                device = deviceNew;
                device__resolvedKey = __key;
            }
        }
        return device;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1110771717)
    public void setDevice(@NotNull Device device) {
        if (device == null) {
            throw new DaoException(
                    "To-one property 'deviceId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.device = device;
            deviceId = device.getId();
            device__resolvedKey = deviceId;
        }
    }

    @Generated(hash = 79695740)
    private transient Long student__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1299365531)
    public Student getStudent() {
        long __key = this.studentId;
        if (student__resolvedKey == null || !student__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            Student studentNew = targetDao.load(__key);
            synchronized (this) {
                student = studentNew;
                student__resolvedKey = __key;
            }
        }
        return student;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1384923540)
    public void setStudent(@NotNull Student student) {
        if (student == null) {
            throw new DaoException(
                    "To-one property 'studentId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.student = student;
            studentId = student.getId();
            student__resolvedKey = studentId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public String getMeanFeatureVector() {
        return this.meanFeatureVector;
    }

    public void setMeanFeatureVector(String meanFeatureVector) {
        this.meanFeatureVector = meanFeatureVector;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1492710689)
    public List<StudentImage> getStudentImages() {
        if (studentImages == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentImageDao targetDao = daoSession.getStudentImageDao();
            List<StudentImage> studentImagesNew = targetDao
                    ._queryStudentImageCollectionEvent_StudentImages(id);
            synchronized (this) {
                if (studentImages == null) {
                    studentImages = studentImagesNew;
                }
            }
        }
        return studentImages;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1313731009)
    public synchronized void resetStudentImages() {
        studentImages = null;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 76995743)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentImageCollectionEventDao() : null;
    }
}
