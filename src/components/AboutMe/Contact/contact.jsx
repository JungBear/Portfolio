import React from 'react';
import Subtitle from '../../../atom/subtitle';
import { contacts } from './contacts';
import ATag from '../../../atom/aTag';

const Contact = () => {
    return (
        <div className='grid grid-rows-1 gap-5 lg:px-6 lg:col-span-2'>
            <Subtitle title={"CONTACT"} />
            <div className='leading-7'>
                {contacts.map((con, idx)=>(
                    <p key={idx} className='breack-all'>
                        <span className='font-bold text-default mr-2'>{con.name}</span>
                        <ATag link={con.link} text={con.text? con.text : con.link} />
                    </p>
                ))}
            </div>
        </div>
    );
};

export default Contact;