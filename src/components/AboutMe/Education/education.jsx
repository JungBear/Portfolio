import React from 'react';
import Subtitle from '../../../atom/subtitle';
import { educations } from './data';
import Text from '../../../atom/text';
import SubText from '../../../atom/subText';
import TableRow from '../../../atom/tableRow';

const Education = ({}) => {
    return (
        <div>
            <Subtitle title={"EDUCATION"} />
            <div>
                {educations.map((education, idx)=>(
                    <TableRow children={        
                        <>
                            <div>
                                <SubText>{education.date}</SubText>
                                <Text>{education.name}</Text>
                                {education.subjects ? (<SubText>{education.subjects}</SubText>) : null}
                            </div>
                            <div className='mt-4 md:mt-0 col-span-4'>{education.content}</div>
                        </>
                    }>
                    </TableRow>

                ))}
            </div>
        </div>
    );
};

export default Education;