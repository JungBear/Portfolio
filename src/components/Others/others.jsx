import React from 'react';
import Title from '../../atom/title';
import { others } from './data';
import TableRow from '../../atom/tableRow';
import SubText from '../../atom/subText';

const Others = () => {
    return (
        <div className='mt-5'>
            <Title title={"👀 OTHERS"} />
            <div className='grid grid-cols-1 gap-y-8 mt-5'>
                    {others.map((other, idx)=>(
                        <div key={idx}>
                            <p className='text-lg font-bold text-default'>{other.title}</p>
                            <div>
                                {other.items.map((item, idx)=>(
                                    <TableRow key={idx}>
                                        <div>
                                            <SubText>{item.date}</SubText>
                                            <p className='font-bold'>{item.title}</p>
                                            <SubText>{item.role}</SubText>
                                        </div>
                                        <div className='sm:col-span-4 mt-4 md:mt-0'>
                                            {item.content}
                                        </div>
                                    </TableRow>
                                ))}
                            </div>
                        </div>
                    ))}

            </div>
        </div>
    );
};

export default Others;