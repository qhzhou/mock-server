package com.studentpal.parents.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import com.studentpal.parents.dto.BaseObject;
import com.studentpal.parents.util.GsonUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public abstract class BaseService<T extends BaseObject> {

    protected abstract Class<T> getType();

    protected List<T> data;

    private AtomicInteger id;

    public BaseService() {
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(getType().getSimpleName().toLowerCase() + ".json");
            data = Lists.newArrayList(GsonUtils.toList(new InputStreamReader(stream), getType()));
            id = new AtomicInteger(data.stream().map(T::getId).max(Integer::compareTo).orElse(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final T findById(int id) {
        for (T datum : data) {
            if (datum.getId() == id) {
                return datum;
            }
        }
        return null;
    }

    public T updateById(T item) {
        int idx = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == item.getId()) {
                idx = i;
                break;
            }
        }
        if (idx >= 0) {
            updateAt(idx, item);
        }
        return item;
    }

    public T updateAt(int idx, T item) {
        Preconditions.checkArgument(idx >= 0 && idx < data.size());
        data.set(idx, item);
        return item;
    }

    public List<T> findAll() {
        return data;
    }

    public int add(T item) {
        item.setId(id.incrementAndGet());
        this.data.add(item);
        return item.getId();
    }

}
