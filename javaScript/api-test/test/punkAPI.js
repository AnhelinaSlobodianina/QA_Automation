import supertest from 'supertest';
const request = supertest("https://api.punkapi.com/v2");

import{expect} from 'chai';

describe('Malt',()=>{
    it('GET /beers/id STATUS', (done)=>{
        request
        .get('/beers/192').end((err,res)=>{
           expect(res.status).to.equals(200);
           done();
        })
    })
    it('GET /beers/id malt is "Extra Pale"', ()=>{
        return request
        .get('/beers/192').then((res)=>{
            expect(res.body[0].id).to.be.equals(192);
            expect(res.body[0].ingredients.malt[0].name).to.be.equals('Extra Pale');
        })
    })
    it('GET /beers/id malt value is 5.3 and the unit is “kilograms”', ()=>{
        return request
        .get('/beers/192').then((res)=>{
            expect(res.body[0].ingredients.malt[0].amount.value).to.equals(5.3);
            expect(res.body[0].ingredients.malt[0].amount.unit).to.equals("kilograms");
        })
    })
})

