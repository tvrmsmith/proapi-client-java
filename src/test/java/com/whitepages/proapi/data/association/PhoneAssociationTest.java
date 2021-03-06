package com.whitepages.proapi.data.association;

import com.whitepages.proapi.api.response.ResponseDictionary;
import com.whitepages.proapi.data.entity.Entity;
import com.whitepages.proapi.data.entity.EntityId;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Copyright 2015 Whitepages, Inc.
 */
public class PhoneAssociationTest {

    @Test
    public void entityResolution() {
        PhoneAssociation assoc = getDefaultAssociation();
        Entity entity = assoc.getEntity();
        assertThat(entity, notNullValue());
        MatcherAssert.assertThat(entity.getId(), equalTo(TestDictionaryFactory.phoneId));
        assertThat(assoc.getPhone(), is(entity));
    }

    @Test(expected = IllegalArgumentException.class)
    public void entityIdTypeContraint() {
        EntityId id = new EntityId(EntityId.EntityType.BUSINESS, UUID.randomUUID().toString());
        new PhoneAssociation(id, new ResponseDictionary(null));
    }

    protected PhoneAssociation getDefaultAssociation() {
        PhoneAssociation assoc = new PhoneAssociation(TestDictionaryFactory.phoneId, TestDictionaryFactory.getSimpleDicationary());
        //NOTE: Fill-in more properties as needed.
        return assoc;
    }

}
