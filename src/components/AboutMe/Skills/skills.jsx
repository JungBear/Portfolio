import React from 'react';
import Subtitle from '../../../atom/subtitle';
import { skills } from './data';
import TableRow from '../../../atom/tableRow';
import Text from '../../../atom/text';
import Ul from '../../../atom/ul';

const Skills = () => {
    return (
        <div>
            <Subtitle title={"SKILLS"} />
            <div>
                {skills.map((skill, idx)=>(
                    <TableRow key={idx}>
                        <div>
                            <Text>{skill.name}</Text>
                        </div>
                        <div className="mt-4 md:mt-0 col-span-4">
                            <Ul>
                                {skill.items.map((item, idx)=>(
                                    <li key={idx}>{item}</li>
                                ))}
                            </Ul>
                        </div>
                    </TableRow>
                ))}
            </div>
        </div>
    );
};

export default Skills;