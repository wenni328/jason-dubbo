package com.jason.webflux.crud.repository;


import com.jason.webflux.crud.entity.City;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @auther: xieyong
 * @date: 2018/8/28 10:35
 * @Description:
 */
@Repository
public class CityRepository {
    //id生成器
    private static final AtomicLong idGenerator = new AtomicLong(0);
    //保存数据的集合，作为伪数据库
    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();

    public Long save(City city) {
        Long id = idGenerator.incrementAndGet();
        city.setId(id);
        repository.put(id, city);
        return id;
    }

    public Collection<City> findAll() {
        return repository.values();
    }


    public City findCityById(Long id) {
        return repository.get(id);
    }

    public Long updateCity(City city) {
        repository.put(city.getId(), city);
        return city.getId();
    }

    public Long deleteCity(Long id) {
        repository.remove(id);
        return id;
    }

}
