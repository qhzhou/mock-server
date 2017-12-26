package com.studentpal.parents.service;

import com.studentpal.parents.dto.SosRecord;

import org.springframework.stereotype.Service;

@Service
public class SosRecordService extends BaseService<SosRecord> {
    @Override
    protected Class<SosRecord> getType() {
        return SosRecord.class;
    }
}
